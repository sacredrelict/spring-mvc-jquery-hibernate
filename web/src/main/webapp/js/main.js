$(function() {

    // Change second currency select options depending on first select value.
    $(".currencyFirstSelect").change(function() {
        var currencyFirstVal = $('.currencyFirstSelect option:selected').val();
        $.ajax({
            type : 'GET',
            url : '/currencies/without/' + currencyFirstVal,
            success : function(data) {
                var select = $('.currencySecondSelect');
                select.empty();
                select.append('<option></option>')
                $.each (data, function (option) {
                    select.append('<option value="'+data[option].id+'">'+data[option].name+'</option>')
                });
            }
        });
    });

    // Get data about currency pair
    $(".currencyPairBtn").click(function() {
        var currencyFirstVal = $('.currencyFirstSelect option:selected').val();
        var currencySecondVal = $('.currencySecondSelect option:selected').val();
        var dateFromVal = $('.dateFrom').val();
        var dateToVal = $('.dateTo').val();
        if (currencyFirstVal.length <= 0 || currencySecondVal.length <= 0 || dateFromVal.length <= 0 || dateToVal.length <= 0) {
            $(".error-block").removeClass('d-none');
            $(".error-block").addClass('d-block');
        } else {
            $(".error-block").removeClass('d-block');
            $(".error-block").addClass('d-none');

            $.ajax({
                type : 'POST',
                url : '/currencyCoefficients/currencyPair',
                data: {
                    currencyFirst: currencyFirstVal,
                    currencySecond: currencySecondVal,
                    dateFrom: dateFromVal,
                    dateTo: dateToVal
                },
                success : function(data) {
                    $(".ajax-table tr:has(td)").remove();
                    $.each(data, function (index, row) {
                        $('.ajax-table tbody').append(
                            '<tr>' +
                            '<td>' + row.id + '<td>' +
                            '<td>' + row.time + '<td>' +
                            '<td>' + row.currencyFirst.name + '<td>' +
                            '<td>' + row.coefficient + '<td>' +
                            '<td>' + row.currencySecond.name + '<td>' +
                            '</tr>'
                        );
                    });
                }
            });
        }
    });

});



