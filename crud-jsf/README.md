Projeto: JSF-sample
========================
Author: Cleiton Oliveira <br>
Technologies: CDI, JSF, JPA, EJB, JBoss WildFly <br>
Summary: JSF CRUD example <br>
Source: 

About
-----------

This is a project with basic setup for 'JSF + Jboss' application. Project Maven 3 with Java EE 7 and Jboss Enterprise Application Platform 6 ou JBoss AS 7, or Jboss WildFly 10.

This configurations is a Java EE 7 compatible with JSF 2.0, PrimeFaces, CDI 1.0, EJB 3.1, JPA 2.0 e Bean Validation 1.0. 

Requirements
-------------------

Tudo que você precisa para construir este projeto é Java 6.0 (Java SDK 1.7), ou superior, Maven 3.0 ou superior, Banco de dados MySql. 

Este projeto foi é projetado para ser executado com JBoss Enterprise Application Platform 6 ou JBoss AS 7. 

Antes executar o projeto:
- Entre na pasta SQL e execute o script SQL_Inicial.sql em seu mysql.
- Acesse o arquivo crud-jsf-ds.xml no projeto crud-jsf:
	- Altere o usuario e senha para acesso ao banco de dados.

- Verifique o driver do mysql em seu JBoss:
	- Acesse o diretorio: %JBOSS_HOME%\modules\com
	- Verifique se possui as pastas mysql\main (caso não exista crie as pastas)
	- Dentro da pasta %JBOSS_HOME%\modules\com\mysql\main deve existir dois arquivos mysql-connector-java-X.X.XX.jar e module.xml 
	- Caso não exista o arquivo mysql-connector-java-X.X.XX.jar efetue o download do mesmo conforme link a seguir (Versão 5.1.29): http://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.29/mysql-connector-java-5.1.29.bundle.jar
	- Caso não exista o arquivo module.xml efetue a criação de um arquivo xml chamado module.xml e adicione o conteudo conforme abaixo:
	```xml
	<?xml version="1.0" encoding="UTF-8"?>

	<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  		<resources>
    		<resource-root path="mysql-connector-java-5.1.29.jar"/>
  		</resources>
  		<dependencies>
    		<module name="javax.api"/>
  		</dependencies>
	</module>
	
- Verifique se o standalone.xml esta com o driver do mysql configurado
	- Acesse o diretório: %JBOSS_HOME%\standalone\configuration
	- Abra o arquivo standalone.xml e localize a tag drivers
	- Dentro desta tag deve existir a declaração do driver do mysql conforme abaixo, caso não exista adicione esta informação.
	```xml
	<driver name="mysql" module="com.mysql">
		<xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
	</driver>
	

Postgres config
---------------


```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.postgresql">
    <resources>
        <resource-root path="postgresql-42.2.22.jar"/>
        <!-- Make sure this matches the name of the JAR you are installing -->
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```

```xml
<datasources>
      <!-- other datasources -->
    <datasource jndi-name="java:jboss/datasources/crud-jsfDS" pool-name="PostgresDS" enabled="true" use-java-context="true">
        <connection-url>jdbc:postgresql://localhost:5432/teste-aula</connection-url>
        <driver>postgres</driver>
        <security>
            <user-name>root</user-name>
            <password>root</password>
        </security>
    </datasource>
    <drivers>
        <!-- other drivers -->
        <driver name="postgres" module="org.postgresql">
            <driver-class>org.postgresql.Driver</driver-class>
            <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
```

Acesso para a aplicação
---------------------

URL para acesso: <http://localhost:8080/crud-jsf/>
