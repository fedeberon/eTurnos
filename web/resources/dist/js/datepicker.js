/**
 * Created by Fede Beron on 30/6/2017.
 */
//Datemask dd/mm/yyyy
$(".date").inputmask("dd-mm-yyyy", {"placeholder": "dd-mm-yyyy"});

//Date spanish
moment.locale('es');

//Date range picker
$('.date').daterangepicker({
    singleDatePicker: true,
    showDropdowns: true,
    format: 'DD-MM-YYYY',
    separator: ' / '
});
