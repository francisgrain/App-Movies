# App-Movies is a web application created during the Web Developer course - TalentForm
<h2>This is a funny application designed for movie enthusiasts, allowing users to search for films by title using a RESTful API connected to the OMDb database. Once a
                      movie is found, all relevant details such as release date,
                      genre, director, cast, and plot are displayed. Users can
                      then add their favorite films to a personalized list for
                      easy access or remove them at any time. The application is
                      secured with SpringBoot Security to protect against CSRF
                      attacks, ensuring that all transactions and data are
                      safeguarded. Developed using Java, SpringBoot, Bootstrap,
                      Thymeleaf, Postman, and MySQL.</h2>
<h3>Dependencies used</h3>:
<li>
implementation 'com.fasterxml.jackson.core:jackson-databind:2.17.1'
	implementation 'org.springframework.boot:spring-boot-starter-mail'
	implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
</li>
