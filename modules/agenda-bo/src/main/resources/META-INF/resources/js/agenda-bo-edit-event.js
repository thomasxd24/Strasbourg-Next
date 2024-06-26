// Champs conditionnelles
var namespace = "_eu_strasbourg_portlet_agenda_AgendaBOPortlet_";
var namespaceAUI = "#" + namespace;

jQuery(function() {

	$('[name='+namespace+'placeType]').on('click change', function(e) {
		var classOfDivToShow = e.target.value;
		var classOfDivToHide = 'sigmanual'.replace(classOfDivToShow, '');
		$('.sig, .manual').hide();
		$('.' + classOfDivToShow).show();
		$('.' + classOfDivToHide + ' input').val('');
		$('.' + classOfDivToHide + ' input[type=checkbox]').attr('checked', false);
		$('.' + classOfDivToHide + ' option').attr('selected', false);
		setConditionalValidators();
	});
	
	$('[name=imageType]').on('click change', function(e) {
		var classOfDivToShow = e.target.value;
		var classOfDivToHide = 'internalImageexternalImage'.replace(classOfDivToShow, '');
		$('.internalImage, .externalImage').hide();	
		$('.' + classOfDivToShow).show();
		$('.' + classOfDivToHide + ' input').val('');
		$('.' + classOfDivToHide + ' .image-thumbnail').remove();
		setConditionalValidators();
	});

	$(":submit").on('click', function(e) {
        allValidate = true;

		setConditionalValidators(e);
	});
	
	function setConditionalValidators() {
		// Validation des champos obligatoires conditionnels
		AUI().use('liferay-form', function() {
			if (!!window.editEvent) {
				var rules = Liferay.Form.get(namespace + 'fm').formValidator.get('rules');
				if (jQuery('.manual').is(':visible')) {
					rules[namespace + 'selectedPlace2'].required = false;
					rules[namespace + 'placeName'].required = true;
					rules[namespace + 'placeCity'].required = true;
				} else {
					rules[namespace + 'selectedPlace2'].required = true;
					rules[namespace + 'placeName'].required = false;
					rules[namespace + 'placeCity'].required = false;
				}
				
				if (jQuery('.internalImage').is(':visible')) {
					rules[namespace + 'imageId'].required = true;
					rules[namespace + 'externalImageURL'].required = false;
					rules[namespace + 'externalImageCopyright'].required = false;
				} else {
					rules[namespace + 'imageId'].required = false;
					rules[namespace + 'externalImageURL'].required = true;
					rules[namespace + 'externalImageCopyright'].required = true;
				}

                var registration = document.querySelectorAll('input[name=' + namespace + 'registrationValue]')[0];
                var registrationDiv = document.getElementById("registrationDiv");
                if(registration.checked){
					rules[namespace + 'maxGauge'].required = true;
                    rules[namespace + 'registrationStartDate'].required = true;
                    rules[namespace + 'registrationEndDate'].required = true;
                } else {
					rules[namespace + 'maxGauge'].required = false;
                    rules[namespace + 'registrationStartDate'].required = false;
                    rules[namespace + 'registrationEndDate'].required = false;
                }
			}
		});
		
	}
	
});

// Périodes
var autoFields = undefined; // Référence au champ répétable (setté plus loin)
(function($) {
	var namespace = "_eu_strasbourg_portlet_agenda_AgendaBOPortlet_"; // Namespace du portlet
	var dateRangePickerLocaleSettings =  { // Configuration française du dateRangePicker
		format: 'DD/MM/YYYY',
		applyLabel: 'Valider',
		applyAndNewLabel: 'Valider et ajouter une nouvelle période',
		cancelLabel: 'Fermer',
		 daysOfWeek: [
            "Di",
            "Lu",
            "Ma",
            "Me",
            "Je",
            "Ve",
            "Sa"
        ],
        monthNames: [
            "Janvier",
            "Février",
            "Mars",
            "Avril",
            "Mai",
            "Juin",
            "Juillet",
            "Août",
            "Septembre",
            "Octobre",
            "Novembre",
            "Décembre"
        ],
        firstDay: 1
	};

	/**
	 * RangePicker répétable
	 */
	// Options du date range picker répétable
	var options = { 
		autoApply: false,
		parentEl: '#portlet_eu_strasbourg_portlet_agenda_AgendaBOPortlet .portlet-body',
		opens: 'right',
		showDates: true,
		autoUpdateInput: false,
		locale: dateRangePickerLocaleSettings
	};

	// Fonction appelée lors du choix d'une nouvelle range
	var onDateChange = function(ev, picker) { 
		// Set du texte du label
		$(this).text(picker.startDate.format('DD/MM/YYYY') + ' - ' + picker.endDate.format('DD/MM/YYYY'));
		// Set des champs input cachés
		$('.startDate', $(this).parent()).val(picker.startDate.format('DD/MM/YYYY'));
		$('.endDate', $(this).parent()).val(picker.endDate.format('DD/MM/YYYY'));
	};

   // Fonction appelé pour ouvrir le calendrier général
	var openGeneralRange = function (ev, picker) {
		// On simule le clic sur le bouton "+" de l'autoField
		// On modifie également l'URL appelée pour récupérer la ligne répétable
		// afin d'ajouter les paramètres de dates de début et de fin
		var formattedStartDate = picker.startDate.format('DD/MM/YYYY');
		var formattedEndDate = picker.endDate.format('DD/MM/YYYY');
		var previousURL = autoFields.url;
		autoFields.url = autoFields.url + '&' + namespace + 'startDate=' + formattedStartDate
			+ '&' + namespace + 'endDate=' + formattedEndDate;
		$('button.add-row', $('#date-fields .lfr-form-row:not(.hide)').first()).trigger('click');

		// On laisse le calendrier ouvert
        $(ev.currentTarget).trigger('click')

		// On reset l'URL à sa valeur initiale
		autoFields.url = previousURL;

		// Réinitialise la période en cours
		$(this).text("Sélectionner");
		// Set des champs input cachés
		$('.startDate', $(this).parent()).val("");
		$('.endDate', $(this).parent()).val("");
    };

	// On active le composant
	$('span.date-range').each(function() {
        dates = $(this).text().split(' - ');
        if(dates.length == 2){
            options.startDate = dates[0];
            options.endDate = dates[1];
        }
        var dateRangePicker = $(this).daterangepicker(options);
        // On attache l'événement de changement de range de date
        $(this).on('apply.daterangepicker', onDateChange);
        $(this).on('applyAndNew.daterangepicker', onDateChange);
        // Lors du clic sur le bouton "Valider et ajouter une nouvelle période"
        $(this).on('applyAndNew.daterangepicker', openGeneralRange);
    });
	
	// Configuration de l'autofield
	AUI().use('liferay-auto-fields', function(Y) {
		if (!!document.getElementById('date-fields')) {
			// Création de l'autofield
			autoFields = new Liferay.AutoFields({
				contentBox : '#date-fields',
				fieldIndexes : namespace + 'periodIndexes',
				namespace : namespace,
				url: getPeriodRowJSPURL
			}).render();
		}
	});

	// Evenement appelé après un "clone" : on doit reactiver le datepicker et rattacher l'event
	$('#date-fields').on('dateRangeCreated', function(event, index) {
	    dates = $('#dateRange' + index).text().split(' - ');
	    if(dates.length == 2){
            options.startDate = dates[0];
            options.endDate = dates[1];
	    }
		dateRangePicker = $('#dateRange' + index).daterangepicker(options);
		$('#dateRange' + index).on('apply.daterangepicker', onDateChange);
		$('#dateRange' + index).on('applyAndNew.daterangepicker', onDateChange);
        $('#dateRange' + index).on('applyAndNew.daterangepicker', openGeneralRange);
	});

	/**
	 * Modification globale des horaires
	 */
	$('#' + namespace + 'changeTimes').on('click', function() { 
		// Au clic sur le bouton "Modifier les horaires", on set les valeurs de tous les champs localisables
		// Et on lance une méthode du composant afin que la modification soit prise en compte
		var newValue = $('#' + namespace + 'timeDetailGenerator').val();
		$('#date-fields .input-localized input[type=text]').each(function() {
			$(this).val(newValue);
			Liferay.component($(this).attr('id')).updateInputLanguage(newValue);
		});
	});
})(jQuery);

// Validation des périodes
function validatePeriods(event) {
	var allValidated = true;
	var dateRanges = document.querySelectorAll('#date-fields .date-range');
	var nbPeriod = 0;
	for (var i = 0; i < dateRanges.length; i++) {
		var dateRange = dateRanges[i];
		// On ne lance la validation que si une période a déjà été sélectionnée
		// et que l'élément ne contient pas la classe "hide"
		if ($(dateRange).text().indexOf('-') > 0 
				&& $(dateRange).parents('.lfr-form-row').attr('class').indexOf('hide') === -1) {
			nbPeriod++;
		}
    }
    if (nbPeriod == 0) {
        $('.no-event-period').show();
        $('html,body').animate({scrollTop: $(namespaceAUI + "eu-dates-and-times").offset().top - 100}, 'slow');
        allValidated = false;
    }else{
        $('.no-event-period').hide();
    }

	if (!allValidated) {
		event.preventDefault();
	} else {
		autoFields.save(event.target);
	}
	return allValidated;
}

// Autocomplete des lieux
jQuery(function() {
		var options = {
			type : "POST",
			serviceUrl : "/api/jsonws/place.place/get-places-by-name-and-language/",
			params : {
				name : '[name]',
				language: 'fr_FR',
				p_auth: Liferay.authToken
			},
			paramName : 'name',
			transformResult : function(response) {
				return {
					suggestions : jQuery.map(
							JSON.parse(response), function(
									dataItem) {
								return {
									value : dataItem.name.fr_FR,
									data : dataItem.idSurfs
								};
							})
				};
			},
			onSelect : function(suggestion) {
				jQuery('#place-autocomplete-hidden-value input').val(
						suggestion.data);
			    jQuery('input.selected-place2').val(suggestion.value);
				jQuery('input.selected-place').val(suggestion.value);
			},
			appendTo : '.place-autocomplete-input-wrapper'
		};
		jQuery('.place-autocomplete-input-wrapper input').autocomplete(
				options);
});

var registrationTrue = document.querySelectorAll('input[name=' + namespace + 'registrationValue]')[0];
var registrationFalse = document.querySelectorAll('input[name=' + namespace + 'registrationValue]')[1];
var registrationDiv = document.getElementById("registrationDiv");
if(registrationTrue.checked){
	registrationDiv.style.display = "block";
} else {
	registrationDiv.style.display = "none";
}
registrationTrue.onchange = function(){
    var rules = Liferay.Form.get(namespace + 'fm').formValidator.get('rules');
    rules[namespace + 'maxGauge'].required = true;
    rules[namespace + 'registrationStartDate'].required = true;
    rules[namespace + 'registrationEndDate'].required = true;
    registrationDiv.style.display = "block";
};
registrationFalse.onchange = function(){
    var rules = Liferay.Form.get(namespace + 'fm').formValidator.get('rules');
    rules[namespace + 'maxGauge'].required = false;
    rules[namespace + 'registrationStartDate'].required = false;
    rules[namespace + 'registrationEndDate'].required = false;
    registrationDiv.style.display = "none";
};

var maxGauge = $('input[name=' + namespace + 'maxGauge]');
maxGauge.on("change paste keyup", function(event) {
    keyword = $(this).val();
    if (keyword > 99999) {
        $(this).val(99999);
    } else if  (keyword < 0) {
        $(this).val(0);
    }
});