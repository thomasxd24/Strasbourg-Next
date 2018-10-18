$("a[href='#step1']").on('click',function(e){
    e.preventDefault();
   $('.mns-moteur-launch').addClass('hide-launcher');
    $('.mns-moteur-wrapper').addClass('show-moteur');
});


function change_question(num_question){
    if(num_question > 1 ){
        $('.mns-questions-pagination .mns-prev').show();
    } else {
        $('.mns-questions-pagination .mns-prev').hide();
    }

    $('.reponse-wrapper').css('min-height',$('.reponse-wrapper').height());


    $('.reponse').fadeOut(150, function() {
        setTimeout(function () {
            $('#question_'+num_question).fadeIn(300).addClass('mns-anim');
        },150);
    });

    $('.mns-questions-dots a').removeClass('current');
    $('.mns-questions-dots a[data-num_question='+num_question+']').addClass('current');
    $('.mns-questions-dots a[data-num_question='+num_question+']').prev('a').addClass('active');
    $('.mns-questions-dots a[data-num_question='+num_question+']').next('a').removeClass('active');

    question_label = $('[data-type=question-label][data-num_question='+num_question+']').text();
    $('[data-type=question-label-wrapper]').text(question_label);
    $('.modal-content').animate({scrollTop:0},500);



    nb_questions = $('.mns-questions-dots a').length;
    mns_num_question = $('.mns-questions-dots a.current').data('num_question') + 1;
    if(mns_num_question > nb_questions) {
        $('.mns-questions-pagination .mns-next').text('Envoyer');
    }
    else{
        $('.mns-questions-pagination .mns-next').text('Suivant');
    }
}

$('.mns-question-wrapper form .reponse').each(function (index) {
    var num_question = index+1;
    $('input[type=radio][name=question_'+num_question+']').change(function() {
        id = $(this).attr('id');
        console.log(num_question);
        $('#question_'+num_question+' label').removeClass('active');
        $('label[for='+id+']').addClass('active');
    })
});


$('.label-wrapper').each(function(){
   $(this).find('label');
});


$('.mns-questions-dots a').on('click', function (e) {
    e.preventDefault();
    change_question($(this).data('num_question'));
});


$('.mns-questions-pagination .mns-prev').on('click', function (e) {
    e.preventDefault();
    num_question = $('.mns-questions-dots a.current').data('num_question') - 1;
    change_question(num_question);
});


$('.mns-questions-pagination .mns-next').on('click', function (e) {
    console.log('ouiiiii');
    e.preventDefault();
    nb_questions = $('.mns-questions-dots a').length;
    num_question = $('.mns-questions-dots a.current').data('num_question') + 1;
    if(num_question > nb_questions) {
        var str = "";
        $("input[type='radio']:checked").each(
          function() {
           var value = $(this).attr('value');
           str = $.grep([str, value], Boolean).join(",");
          }); 

        window.location.assign("/web/christmas-2018/recherche-experience?p_p_id=eu_strasbourg_portlet_search_asset_SearchAssetPortlet&p_p_lifecycle=0&_eu_strasbourg_portlet_search_asset_SearchAssetPortlet_categoriesIds="+str);
       // $('#mns-moteur_experientiel').submit();
    } else {
        change_question(num_question);
    }

});



$(window).load(function() {
    $('.mns-page-experientielle').addClass('mns-loaded');
});