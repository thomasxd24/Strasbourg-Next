$(function() {

    /*
    * Gestion des likes/dislikes
    */
    $(document).on("click", "[href$='-approuv'], [href$='like-pro']", function(e) {

        e.preventDefault();
        e.stopPropagation();

        // Sauvegarde de l'élément
        var element = $(this);

        // L'élément a t-il un affiche du compteur en texte ou en span ?
        var counterType = $(this).attr('href').endsWith('-approuv') ? "span" : "text" ;

        // Récupération des attributs du like
        var title = $(this).data("title");
        var isdislike = $(this).data("isdislike");
        var typeid = $(this).data("typeid");
        var entityid = $(this).data("entityid");
        var entitygroupid = $(this).data("entitygroupid") ? $(this).data("entitygroupid") : 0;

        // Appel au service remote Liferay
        Liferay.Service(
            '/like.like/add-like-link',
            {
                title: title,
                isDislike: isdislike,
                typeId: typeid,
                entityId: entityid,
                entityGroupId: entitygroupid
            },
            function(obj) {
                // En cas de succès, on effectue la modification des éléments visuels
                // selon la réponse et le type de l'élément
                if (obj.hasOwnProperty('success')) {
                    switch(obj['success']) {
                        case "like added":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) + 1);
                            } else {
                                element.text(+parseInt(element.text()) + 1);
                            }
                            break;
                        case "dislike added":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) + 1);
                            } else {
                                element.text(+parseInt(element.text()) + 1);
                            }
                            break;
                        case "like mind changed added":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) + 1);
                                element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                            } else {
                                element.text(+parseInt(element.text()) + 1);
                                element.siblings().first().text(+parseInt(element.siblings().first().text()) - 1);
                            }
                            break;
                        case "dislike mind changed added":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) + 1);
                                element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                            } else {
                                element.text(+parseInt(element.text()) + 1);
                                element.siblings().first().text(+parseInt(element.siblings().first().text()) - 1);
                            }
                            break;
                        case "like deleted":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) - 1);
                            } else {
                                element.text(+parseInt(element.text()) - 1);
                            }
                            break;
                        case "dislike deleted":
                            element.toggleClass('active');
                            if (counterType === "span") {
                                element.find('strong').text(+parseInt(element.text()) - 1);
                            } else {
                                element.text(+parseInt(element.text()) - 1);
                            }
                            break;
                    }

                }
                // Sinon on affiche un message d'erreur
                else if (obj.hasOwnProperty('error')) {
                    if (obj['error'] == 'notConnected') {
                        // Si l'utilisateur n'est pas connecté
                        e.preventDefault();
                        $("#myModal").modal();
                    } else {
                        // Autre erreur
                        alert('Une erreur est survenue.');
                    }
                }
            }
        );

    });

    /*
    * Gestion des participation à un événement
    */
    $(function() {
        $(document).on("click", "[href='#Participe'], span[name^='#Participe']", function(e) {

            e.preventDefault();
            e.stopPropagation();

            // Sauvegarde de l'élément
            var element = $(this);
            var elementType = $(this).attr('href') === '#Participe' ? 'a' : 'span';

            // Récupération des attributs du like
            var eventid = $(this).data("eventid");
            var groupid = $(this).data("groupid") ? $(this).data("groupid") : 0;

            // Met à jour le compteur de participant
            function updateCounter(num) {
                var stringNum = num.toString();
                var nbDigits = stringNum.length;
                stringNum = "0".repeat(5 - nbDigits) + stringNum;
                for (i = 1; i <= 5; i++) {
                    $('.pro-compt span:nth-child('+i+')').text(stringNum[i-1]);
                }
            }

            // Appel au service remote Liferay
            Liferay.Service(
                '/agenda.eventparticipation/add-event-participation-link',
                {
                    eventId: eventid,
                    groupId: groupid
                },
                function(obj) {
                    // En cas de succès, on effectue la modification des éléments visuels
                    // selon la réponse et le type de l'élément
                    if (obj.hasOwnProperty('success')) {
                        switch(obj['success']) {
                            case "participation added":
                                element.toggleClass('active');
                                if (elementType === "a")
                                    updateCounter(parseInt($('.pro-compt').text()) + 1);
                                else
                                    element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) + 1);
                                break;
                            case "participation deleted":                                
                                element.toggleClass('active');
                                if (elementType === "a")
                                    updateCounter(parseInt($('.pro-compt').text()) - 1);
                                else
                                    element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                                break;
                        }
                    }

                    // Sinon on affiche un message d'erreur
                    else if (obj.hasOwnProperty('error')) {
                        if (obj['error'] == 'notConnected') {
                            // Si l'utilisateur n'est pas connecté
                            e.preventDefault();
                            $("#myModal").modal();
                        } else {
                            // Autre erreur
                            alert('Une erreur est survenue.');
                        }
                    }
                }
            );
        });
    });

});