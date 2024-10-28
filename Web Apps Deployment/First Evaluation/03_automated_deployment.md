# Table of contents
- [Table of contents](#table-of-contents)
- [Automated deployment](#automated-deployment)
- [Folder structure](#folder-structure)
- [`Target`folder](#targetfolder)
- [Aumotamed deployment tasks](#aumotamed-deployment-tasks)
  - [Transforming SASS into CSS](#transforming-sass-into-css)
  - [Transforming TypeScript into JavaScript](#transforming-typescript-into-javascript)
- [Scripts `npm`](#scripts-npm)
- [Maven](#maven)

# Automated deployment
[Up](#table-of-contents)

Automate the deployment process to reduce the risk of human error and to speed up the deployment process.

The deployment coould be done dozens of times a day, so it is important to automate the process.

# Folder structure
[Up](#table-of-contents)

This is the first step.

In `Git`, we must save not only the `src`folder, but also the `mi-proyecto`folder. In reality, all folders form the project, not only the `src`one.

Possible exceptions: `dist`or `node-modules`-

Structure:

```bash
/mi-proyecto
  /src              //Donde está todo el código fuente de la aplicación
    /main
      /java
        /com
          /daw
            /peliculas
               Main.java
      /resources
        /static
          index.html
          /assets
            /img
            /fonts
            /media      //Audios y Videos
          /vendor       //librerías bajadas de internet (también se puede llamar lib)
            /jquery      
            /boostrap
          /scss         //Código en SASS
          /css          //código en CSS
          /ts           //Código en TypeScript
          /js           //código en JavaScript
  /docs             //Documentación de la aplicación. Es la documentación con los diagramas UML, el JavaDoc, etc.
  /disenyo          //Donde están las imágenes en formato Photshop o  similares que estamos visualmente diseñando 
  /db               //Ficheros ".sql" de creación de la base de datos, etc. Es todo lo necesario para tener la base de datos preparada desde cero. Incluye insertar datos que siemrpe deben estar , como por ejemplo códigos de provincias. Pero NO las inserciones de los datos del usuario.
  /scripts          //Scripts varios. Normalmente están relacionados con el despliegue de la aplicación. Es lo mas importante en este módulo de despliegue.
    deploy.sh
    build.sh
  /node_modules     //Carpeta que usa node para guardar lo que instalamos de NodeJS
  /target             //El código "compilado" de la aplicación. Eso incluye transformar de TypeScript a JavaScript o de SASS a CSS,etc.
    AppPeliculas-0.0.1-SNAPSHOT.jar
  package.json
```

# `Target`folder
[Up](#table-of-contents)

The target folder is the most important for the deployment module since it contains the project as it will be deployed.

> Note: In other IDEs like NetBeans, the target folder is called `dist`.

Changes respect to the `src`folder:
- Compile the Java source code to the compiled in .class files.
- Minimize code: Make JavaScript or CSS code smaller. 
  - This is done to make web pages load faster. 
  - It usually consists of removing comments, carriage returns, etc.
- Obfuscate the code: To avoid that someone can copy our code is usually, for example, change the name of the variables by names without sense. 
  - Normally it is minimized and obfuscated at the same time.
- Transpiling: It is to transform the source code from one language to another. It is used:
  - TypeScript to JavaScript: TypeScript is a language with higher typing than JavaScript and is often used instead of JavaScript. As browsers do not support TypeScript it has to be converted (transpiled) from TypeScript to JavaScript.
  - SASS to CSS: SASS is a language similar to CSS but with greater functionality. As browsers do not support SASS it must be converted (transpiled) from SASS to CSS. In SASS it is also often said to transform the code from SASS to CSS instead of saying “transpile”.
- Etc.

# Aumotamed deployment tasks
[Up](#table-of-contents)

Let's see now an example of how to deploy a web application in Java with SASS , TypeScript and deployed in Apache.
- Build (in Maven it is called `package`).
  - Copy the code from `src` to `target`.
- Compile the Java code.
- Transpile the SASS code into CSS inside the `target` folder.
- Transpile TypeScript code into JavaScript inside the `target` folder.
- Delete the SASS code from the `target` folder.
- Delete the TypeScript code from the `target` folder.
- Generate the `.jar`.
- Deploy.
  - Copy the `.jar` from the `target` folder to the server where it is going to be executed or copy the .war in Tomcat.
- Execute.
  - Execute the `.jar`.

To do all these tasks we are going to use Scripts of the operating system, for example in Linux we will use “Bash” and the npm Script that we are going to see later.

## Transforming SASS into CSS
[Up](#table-of-contents)

- Install SASS: `npm install -g sass`.
- Transform SASS into CSS: `sass  ./scss/main.scss ./css/main.css`.

## Transforming TypeScript into JavaScript
[Up](#table-of-contents)

- Install TypeScript: `npm install -g typescript`.
- Transform TypeScript into JavaScript: `tsc --outDir ./js ./ts/*.ts`.

# Scripts `npm`
[Up](#table-of-contents)

To do the tasks that we have just indicated, we will make Bash scripts that will be left in the `/scripts` folder. 

However, there may be a large number of scripts there or we may want to use another folder or another language. 

To unify all this in the web projects, we are going to homogenize the execution of these scripts by means of the npm Scripts.

Websites that explain npm Scripts:
- [npm scripts](https://docs.npmjs.com/cli/v9/using-npm/scripts).
- [Why npm scripts](https://css-tricks.com/why-npm-scripts/).
- [npm is an amazing build tool](http://lucasmreis.github.io/blog/npm-is-an-amazing-build-tool/).

Let's see an example of how to use npm Scripts to transform SASS into CSS:

- Create a script for Node inside of `package.json`:
```json
"scripts": {
  "compile-scss": "sass  ./scss/main.scss ./css/main.css"
}
```

- Execute the script:
```bash
npm run compile-scss
```

What have we won with this? That now all the tasks that we are going to do are in the `package.json` file and we can execute them as `npm run name-task`.

3 scripts we should have in every project:
- `build`: Compiles the code `src` and leaves it in `target`. This includes the transformation of SASS to CSS and TypeScript to JavaScript.
```json
"scripts": {
  "build": ".\\scripts\\build.sh"
}
```
```bash
npm run build
```
- Execute a script when something changes.
  - What it [does](https://www.npmjs.com/package/onchange):
```bash
# On every change run `npm test`. 
onchange 'app/**/*.js' 'test/**/*.js' -- npm test
 
# On every change restart `server.js` (by killing the running process). 
onchange -i -k '**/*.js' -- node server.js
 
# On every change `echo` file change. 
onchange '**/*.js' -- echo '{{event}} to {{file}}'
```
```bash
npm install onchange -g
```
- Show a message everytime something changes in a JS file:
```bash
onchange '**/*.js' -- echo Ha cambiado un fichero JavaScript
```

# Maven
[Up](#table-of-contents)

Now we have to call our script of `npm run build` from Maven.

We will use the plugin from Maven `exec-maven-plugin`.

We will add the next XML to the `pom.xml` file:
```xml
<plugin>
   <groupId>org.codehaus.mojo</groupId>
   <artifactId>exec-maven-plugin</artifactId>
   <version>3.0.0</version>
   <executions>
      <execution>
         <id>build-cliente</id>
         <phase>process-resources</phase>
         <goals>
            <goal>exec</goal>
         </goals>
         <configuration>
            <executable>npm</executable>
            <!-- Comando npm -->
            <workingDirectory>${project.basedir}</workingDirectory>
            <arguments>
               <argument>run</argument>
               <argument>build</argument>
            </arguments>
         </configuration>
      </execution>
   </executions>
</plugin>
```
