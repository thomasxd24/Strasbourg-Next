create table project_BudgetParticipatif (
	uuid_ VARCHAR(75) null,
	budgetParticipatifId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	description TEXT null,
	summary VARCHAR(400) null,
	budget VARCHAR(75) null,
	motif TEXT null,
	placeTextArea VARCHAR(400) null,
	inTheNameOf VARCHAR(400) null,
	citoyenLastname VARCHAR(75) null,
	citoyenFirstname VARCHAR(75) null,
	citoyenAdresse VARCHAR(400) null,
	citoyenPostalCode LONG,
	citoyenCity VARCHAR(400) null,
	citoyenPhone VARCHAR(75) null,
	citoyenMobile VARCHAR(75) null,
	citoyenEmail VARCHAR(400) null,
	citoyenBirthday DATE null,
	hasCopyright BOOLEAN,
	videoUrl VARCHAR(400) null,
	imageTimeline LONG,
	opacityImage DOUBLE,
	isCrush BOOLEAN,
	crushComment TEXT null,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(400) null,
	budgetPhaseId LONG,
	parentId LONG
);

create table project_BudgetPhase (
	uuid_ VARCHAR(75) null,
	budgetPhaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(75) null,
	description TEXT null,
	numberOfVote LONG,
	isActive BOOLEAN,
	beginDate DATE null,
	endDate DATE null,
	beginVoteDate DATE null,
	endVoteDate DATE null
);

create table project_BudgetSupport (
	uuid_ VARCHAR(75) null,
	budgetSupportId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	citoyenLastName VARCHAR(75) null,
	citoyenFirstname VARCHAR(75) null,
	citoyenBirthday DATE null,
	citoyenAddress VARCHAR(75) null,
	citoyenMail VARCHAR(75) null,
	citoyenPostalCode LONG,
	citoyenMobilePhone VARCHAR(75) null,
	citoyenPhone VARCHAR(75) null,
	citoyenCity VARCHAR(75) null,
	publikUserId VARCHAR(75) null,
	budgetParticipatifId LONG
);

create table project_Initiative (
	uuid_ VARCHAR(75) null,
	initiativeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	description TEXT null,
	placeTextArea VARCHAR(75) null,
	inTheNameOf VARCHAR(75) null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(400) null,
	mediaChoice BOOLEAN,
	assetEntryId LONG,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(400) null,
	publicationDate DATE null
);

create table project_InitiativeHelp (
	uuid_ VARCHAR(75) null,
	initiativeHelpId LONG not null primary key,
	createDate DATE null,
	publikUserId VARCHAR(75) null,
	initiativeId LONG,
	helpTypes VARCHAR(75) null,
	groupId LONG,
	message VARCHAR(400) null,
	helpDisplay BOOLEAN
);

create table project_Participation (
	uuid_ VARCHAR(75) null,
	participationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	contactName VARCHAR(75) null,
	contactLine1 VARCHAR(400) null,
	contactLine2 VARCHAR(400) null,
	contactPhoneNumber VARCHAR(75) null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(400) null,
	mediaChoice BOOLEAN,
	descriptionChapeau VARCHAR(400) null,
	descriptionBody TEXT null,
	consultationPlacesBody TEXT null,
	imageId LONG,
	filesIds VARCHAR(400) null,
	eventsIds VARCHAR(75) null,
	publicationDate DATE null,
	expirationDate DATE null
);

create table project_Petition (
	uuid_ VARCHAR(75) null,
	petitionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	summary VARCHAR(500) null,
	description TEXT null,
	placeTextArea VARCHAR(400) null,
	filesDownload VARCHAR(75) null,
	publicationDate DATE null,
	expirationDate DATE null,
	extensionDate DATE null,
	quotaSignature LONG,
	inTheNameOf VARCHAR(400) null,
	petitionnaireLastname VARCHAR(75) null,
	petitionnaireFirstname VARCHAR(75) null,
	petitionnaireBirthday DATE null,
	petitionnaireAdresse VARCHAR(400) null,
	petitionnairePostalCode LONG,
	petitionnaireCity VARCHAR(400) null,
	petitionnairePhone VARCHAR(75) null,
	petitionnaireEmail VARCHAR(400) null,
	isSupported BOOLEAN,
	supportedBy VARCHAR(75) null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(75) null,
	mediaChoice BOOLEAN,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(400) null
);

create table project_PlacitPlace (
	uuid_ VARCHAR(75) null,
	placitPlaceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	placeName STRING null,
	placeStreetNumber VARCHAR(75) null,
	placeStreetName VARCHAR(75) null,
	placeZipCode VARCHAR(75) null,
	placeCityId LONG,
	imageId LONG,
	projectId LONG,
	participationId LONG,
	petitionId LONG,
	saisineObservatoireId LONG,
	budgetParticipatifId LONG,
	initiativeId LONG,
	placeSIGId VARCHAR(75) null
);

create table project_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(400) null,
	opacityImage DOUBLE,
	description TEXT null,
	detailURL VARCHAR(75) null,
	budget VARCHAR(75) null,
	label VARCHAR(75) null,
	duration VARCHAR(75) null,
	partners TEXT null,
	contactName VARCHAR(75) null,
	contactLine1 VARCHAR(400) null,
	contactLine2 VARCHAR(400) null,
	contactPhoneNumber VARCHAR(75) null,
	imageId LONG
);

create table project_ProjectFollowed (
	projectFollowedId LONG not null primary key,
	createDate DATE null,
	publikUserId VARCHAR(75) null,
	projectId LONG,
	groupId LONG
);

create table project_ProjectTimeline (
	projectTimelineId LONG not null primary key,
	startDay INTEGER,
	spacing INTEGER,
	date_ DATE null,
	dateFormat VARCHAR(75) null,
	title VARCHAR(400) null,
	link VARCHAR(400) null,
	projectId LONG,
	budgetParticipatifId LONG
);

create table project_SaisineObservatoire (
	saisineObservatoireId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(400) null,
	summary VARCHAR(500) null,
	description TEXT null,
	placeTextArea VARCHAR(400) null,
	filesDownload VARCHAR(75) null,
	inTheNameOf VARCHAR(400) null,
	isOfficial BOOLEAN,
	cityResponse TEXT null,
	projectTarget TEXT null,
	petitionnaireLastname VARCHAR(75) null,
	petitionnaireFirstname VARCHAR(75) null,
	petitionnaireBirthday DATE null,
	petitionnaireAdresse VARCHAR(400) null,
	petitionnairePostalCode LONG,
	petitionnaireCity VARCHAR(400) null,
	petitionnairePhone VARCHAR(75) null,
	petitionnaireEmail VARCHAR(400) null,
	isSupported BOOLEAN,
	supportedBy VARCHAR(75) null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(75) null,
	mediaChoice BOOLEAN,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(400) null
);

create table project_Signataire (
	uuid_ VARCHAR(75) null,
	signataireId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	signataireName VARCHAR(75) null,
	signataireFirstname VARCHAR(75) null,
	birthday DATE null,
	address VARCHAR(400) null,
	mail VARCHAR(400) null,
	postalCode LONG,
	mobilePhone VARCHAR(75) null,
	phone VARCHAR(75) null,
	city VARCHAR(400) null,
	signatureDate DATE null,
	publikUserId VARCHAR(75) null,
	petitionId LONG
);