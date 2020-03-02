
[![Maven Central](https://img.shields.io/maven-central/v/com.github.enesusta/turkish-citizen-validator?color=red&style=flat-square)](http://search.maven.org/artifact/com.github.enesusta/turkish-citizen-validator)
[![Issues](https://img.shields.io/github/issues-raw/enesusta/turkish-citizen-validator.svg?maxAge=25000)](https://github.com/enesusta/turkish-citizen-validator/issues)

##### Quick Installation 

If you are using **Maven** you can add the repository by adding the following XML to your project `pom.xml` file.

```xml
<dependency>
  <groupId>com.github.enesusta</groupId>
  <artifactId>turkish-citizen-validator</artifactId>
  <version>1.3.3</version>
</dependency>
```

##### How can I use it?

Validator is based on two components.

- Citizen
- CitizenValidator

##### Citizen

You can create **a Citizen object** in two ways.

- The first of these and recommended way is:

Use `CitizenBuilder`

```java
import com.github.enesusta.soap.builder.CitizenBuilder;
import com.github.enesusta.soap.domain.Citizen;

public class Tutorial {
    public static void main(String[] args) {

        Citizen citizen = CitizenBuilder
                .getInstance()
                .setId(12345678910L)
                .setName("Enes")
                .setSurname("Usta")
                .setBirthYear(1998)
                .build();

    }
}
```

ID must be 11 digits long type

- Another way is (not recommended):

```java
import com.github.enesusta.soap.domain.Citizen;

public class Tutorial {
    public static void main(String[] args) {
        Citizen citizen = new Citizen(12345678910L, "Enes", "Usta", 1998);
    }
}
```

##### CitizenValidator

It's easy to use. Just follow the code.

```java
import com.github.enesusta.soap.builder.CitizenBuilder;
import com.github.enesusta.soap.domain.Citizen;
import com.github.enesusta.soap.validator.CitizenValidator;
import com.github.enesusta.soap.validator.DefaultCitizenValidator;

public class Tutorial {
    public static void main(String[] args) {

        Citizen citizen = CitizenBuilder
                .getInstance()
                .setId(12345678910L)
                .setName("Enes")
                .setSurname("Usta")
                .setBirthYear(1998)
                .build();

        CitizenValidator citizenValidator = new DefaultCitizenValidator();
        boolean isValidId = citizenValidator.validate(citizen);

    }
}
```

##### License

This code is under the **MIT**

> It's open source. Feel free.
