# int-springboot-batch
Projet Batch avec Spring Boot 2 et Java 8 

## Tutoriel 1 : Utilisation d'une base de données en mémoire dans Spring Boot 2 

1) L'utilisation d'une base de données relationnelle (DB2, Mysql) demande beaucoup de configuration :

- Installation d'une base de données
- Configuration des schémas et des tables
- Alimenter les tables avec des données
- Configuration de la datasource et autres codes pour connecter l'application à la base de données
- Quand on réalise des tests unitaires, on aimerait avoir des données et des cas de tests à jour
  et ne pas impacter le jeu de données des autres développeurs qui peuvent réaliser des tests sur la base de données
  en même temps que nous.

2) Caractéristiques d'une base de données en mémoire

- Une base de données en mémoire est crée quand l'application démarre et est détruite quand l'application s'arrête
- Il n'y a aucune configuration applicative ni d'infrastructure à changer, donc aucune maintenance à faire
- Son usage est idéal pour faire des POCs et des tests unitaires 
- Spring Boot fournit une configuration simple pour passer en toute transparence 
  d'une base de données réelle à une base en mémoire (H2)

3) La base de données en mémoire H2

- C'est une base de données relationnelle écrite en Java qu'on peut embarquer dans une application  
  Java ou exécuter en mode client-serveur

- Il supporte un sous ensemble de standards SQL et est administrable via une console web

4) Administration de la base de données H2

- Télécharger le fichier zip "Platform-independent" de la distribution H2

- Dézipper la distribution et aller sur h2/bin et lancer l'éxécutable h2.bat(sur Windows)

- Au premier lancement de la console, un fichier ".h2.server.properties" est crée dans le répertoire 
  user/home. 
  
  Ce fichier modifiable contient les properties suivantes : 
  
  webAllowOthers: Autoriser d'autres ordinateurs à s'y connecter (par défaut false)
  
  webPort: Le port de la console web H2 (par défaut 8082)
  
  webSSL: Utilisation de connections encryptées TLS(HTTPS, par défaut false)
  
  webAdminPassword: Mot de passe pour accéder aux outils de la console web H2 (par défaut non renseigné)

  - La base de données H2 supporte différents modes de connexion
    Ceci est fait en utilisant différents types d'URL :  

    A) En mémoire : 
    
    ```
    jdbc:h2:mem:<databaseName> 
    jdbc:h2:mem:test_mem
    ```

    B) Connection embarquée, en local

    ```
    jdbc:h2:[file:][<path>]<databaseName>
    jdbc:h2:~/test
    jdbc:h2:file:/data/sample
    jdbc:h2:file:C:/data/sample (seulement sur Windows)
    ```
 
  - L'url de connexion à la console d'administration est http://localhost:8080/login.do

5) Spring Boot et H2
  
- La seule configuration que nous avons besoin de faire au niveau du projet Spring Boot
  est de rajouter la librairie H2 comme dépendance maven

```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

- H2 fournit une interface web (H2 Console) pour visualiser les données
  Dans Spring Boot on active la console web en déclarant dans le fichier application.properties la propriété suivante 
    
  ```
    spring.h2.console.enabled=true
  ```


A) Création d'une entité objet avec une clé primaire id

```
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
}
```


6) Initialisation d'une base de données avec Spring Boot

- Quand on crée des entités JPA dans une application Spring Boot, ce dernier va automatiquement créer des tables vide dans la base de données H2 au démarrage.

- Dans le fichier data.sql qu'on place dans src/main/resources (pour l'application) ou test/main/resources (pour les tests)
  on peut ajouter des commandes SQL d'insertion de données pour alimenter les tables que Spring Boot vient de créer pour nous.

- Dans le fichier schema.sql, on peut définir les scripts de création des tables si on ne souhaite pas que Spring Boot génère les tables à partir des entités JPA.
  Pour cela il faut fixer la stratégie de génération automatique DDL à none : spring.jpa.hibernate.ddl-auto=none

7) Mise en place d'un test unitaire avec Spring Boot, JPA et H2

- Modifier le scope de la dépendance maven H2 et le mettre à "test"

```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>
```

- Créer les fichiers properties (application.properties, fonc.properties, tech.properties) dans le répertoire src/test/resources

- Stratégie de génération automatique DDL fixé à create-drop : 

```
spring.jpa.hibernate.ddl-auto=create-drop
```

- Annotation @Sql

Cette annotation fournit par Spring est une manière d'initialiser et d'alimenter nos schémas de tests

Exemple de test unitaire

```

    @Sql({"/student_schema.sql", "/import_student.sql"})
    public class SpringBootInitialLoadIntegrationTest {
 
        @Autowired
        private StudentRepository studentRepository;
 
        @Test
        public void testLoadDataForTestClass() {
            assertEquals(3, studentRepository.findAll().size());
        }
    }
```


## Tutoriel 2 : Pro JPA 2 in Java EE 8 


- ORM : Object Relational Mapping 
  C'est la conversion d'un modèle de données relationnelles (provenant du résultat d'une requête SQL) en modèle objet (java) utilisé dans l'application
 


## Notes

- Pour lancer Spring Boot avec un fichier de configuration autre que application.properties (par défaut), on peut spécifier le nom du fichier properties avec l'option "--spring.config.location"

Exemple : 

```
java -jar app.jar 
--spring.config.name=application,fonc,tech
--spring.config.location=classpath:/fonc/properties/,classpath:/tech/properties/
```

```
mvn spring-boot:run 
-Dspring.config.name=application,fonc,tech
-Dspring.config.location=classpath:/fonc/,classpath:/tech/
```

## Documentation

https://www.springboottutorial.com/spring-boot-and-h2-in-memory-database

https://www.baeldung.com/spring-boot-h2-database

https://www.baeldung.com/liquibase-refactor-schema-of-java-app

http://www.h2database.com/html/tutorial.html

https://www.baeldung.com/spring-boot-data-sql-and-schema-sql

https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

https://openclassrooms.com/fr/courses/4668056-construisez-des-microservices/5123366-utilisez-jpa-pour-communiquer-avec-une-base-de-donnees

https://dev.to/martinbelev/how-to-enable-junit-5-in-new-spring-boot-project-29a8

https://blog.oxiane.com/2019/05/03/eclipse-photon-un-meilleur-support-de-junit-5-et-des-tests/























