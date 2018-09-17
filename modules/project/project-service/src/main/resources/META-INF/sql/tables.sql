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
	author VARCHAR(75) null,
	description TEXT null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(400) null,
	mediaChoice BOOLEAN,
	assetEntryId LONG,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(75) null,
	consultationPlacesText VARCHAR(75) null,
	consultationPlacesBody TEXT null,
	publicationDate DATE null
);

create table project_InitiativeHelp (
	initiativeHelpId LONG not null primary key,
	createDate DATE null,
	publikUserId VARCHAR(75) null,
	initiativeId LONG,
	groupId LONG,
	message VARCHAR(75) null
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
	author VARCHAR(75) null,
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
	filesIds VARCHAR(75) null,
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
	title VARCHAR(75) null,
	description TEXT null,
	placeTextArea VARCHAR(75) null,
	filesDownload VARCHAR(75) null,
	publicationDate DATE null,
	expirationDate DATE null,
	quotaSignature LONG,
	petitionnaireLastname VARCHAR(75) null,
	petitionnaireFirstname VARCHAR(75) null,
	petitionnaireBirthday DATE null,
	petitionnaireAdresse VARCHAR(75) null,
	petitionnairePostalCode LONG,
	petitionnaireCity VARCHAR(75) null,
	petitionnairePhone VARCHAR(75) null,
	petitionnaireEmail VARCHAR(75) null,
	videoUrl VARCHAR(75) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(75) null,
	mediaChoice BOOLEAN,
	consultationPlacesText VARCHAR(75) null,
	consultationPlacesBody VARCHAR(75) null,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(75) null
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
	opacityImage DECIMAL(3.2) 1,
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
	title VARCHAR(400) null,
	link VARCHAR(400) null,
	projectId LONG
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
	address VARCHAR(75) null,
	mail VARCHAR(75) null,
	postalCode LONG,
	mobilePhone VARCHAR(75) null,
	phone VARCHAR(75) null,
	city VARCHAR(75) null,
	signatureDate DATE null,
	publikUserId VARCHAR(75) null,
	petitionId LONG
);