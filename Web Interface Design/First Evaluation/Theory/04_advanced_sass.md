# Table of contents

- [Table of contents](#table-of-contents)
- [Mixings](#mixings)
- [Functions](#functions)
- [Arrays](#arrays)
- [Maps](#maps)
- [Loop @for to](#loop-for-to)
- [Loop @for through](#loop-for-through)
- [Loop @each of an array](#loop-each-of-an-array)
- [Loop @each of a map](#loop-each-of-a-map)
- [Conditional @if](#conditional-if)
- [Color functions](#color-functions)
- [CSS variables](#css-variables)
  - [Creation of a CSS variable with SASS](#creation-of-a-css-variable-with-sass)

# Mixings
[Up](#table-of-contents)

They are like peaces of CSS code that you can reuse in another CSS class.

It is like a function.

They are very useful to avoid repeating code.

```scss
@mixin box-shadow($color) {
  -webkit-box-shadow: 2px 10px 24px $color;
  -moz-box-shadow: 2px 10px 24px $color;
  box-shadow: 2px 10px 24px $color;
}
 
.c-button {
  color: #FF0000;
  @include box-shadow(#FF0000);
}
 
.c-panel {
  color: #00FF00;
  @include box-shadow(#00FF00);
}
```

It will be transformed into:
```css
.c-button {
  color: #FF0000;
  -webkit-box-shadow: 2px 10px 24px #FF0000;
  -moz-box-shadow: 2px 10px 24px #FF0000;
  box-shadow: 2px 10px 24px #FF0000;
}
 
.c-panel {
  color: #00FF00;
  -webkit-box-shadow: 2px 10px 24px #00FF00;
  -moz-box-shadow: 2px 10px 24px #00FF00;
  box-shadow: 2px 10px 24px #00FF00;
}
```

# Functions
[Up](#table-of-contents)

They are like mixings but they return a value.

```scss
@function getBorderSize($size) {
  @return 10px * $size;
}
 
.c-button {
  color: #FF0000;
  border: getBorderSize(2) solid #00FF00;
}
```

It will be transformed into:
```css
.c-button {
  color: #FF0000;
  border: 20px solid #00FF00;
}
```

# Arrays
[Up](#table-of-contents)

In order to access into an array you have to use the `nth` function.

The index starts at 1.

```scss
$lista:(10px,12px,20px,40px);
 
$indice:1;
$valor:nth($lista,$indice);
```

In order to obtain the length of an array you have to use the `length` function.

```scss
$lista:(10px,12px,20px,40px);
 
$tamanyo:length($lista);
```

# Maps
[Up](#table-of-contents)

In order to access into a map you have to use the `map-get` function.

```scss
$mapa:(
    "a": enero,
    "b": febrero
);
 
$clave:a;
$valor:map-get($mapa,$clave);
```

In order to obtain the keys of a map you have to use the `map-keys` function.

```scss
$mapa:(
    "a": enero,
    "b": febrero
);
 
 
$keys:map-keys($mapa);
```
We obtain an array with the keys.

# Loop @for to
[Up](#table-of-contents)

It is used to repeat a block of code a number of times from `0` to `n-1`.

```scss
@for $i from 0 to 4 {
  .g--border-#{$i} {   
      border: 10px * $i solid #00FF00; 
  }
}
```

It will be transformed into:
```css
.g--border-0 {
  border: 0px solid #00FF00;
}
 
.g--border-1 {
  border: 10px solid #00FF00;
}
 
.g--border-2 {
  border: 20px solid #00FF00;
}
 
.g--border-3 {
  border: 30px solid #00FF00;
}
```

# Loop @for through
[Up](#table-of-contents)

It is used to repeat a block of code a number of times from `n` to `m`.

```scss
@for $i from 1 through 4 {
  .g--border-#{$i} {   
      border: 10px * $i solid #00FF00; 
  }
}
```

It will be transformed into:
```css
.g--border-1 {
  border: 10px solid #00FF00;
}
 
.g--border-2 {
  border: 20px solid #00FF00;
}
 
.g--border-3 {
  border: 30px solid #00FF00;
}
 
.g--border-4 {
  border: 40px solid #00FF00;
}
```

# Loop @each of an array
[Up](#table-of-contents)

It is used to repeat a block of code for each element of an array.

```scss
$lista:(3px,6px,7px,9px);
 
@each $value in $lista {
  .g--padding-#{$value} {
    padding: $value;
  }
}
```

It will be transformed into:
```css
.g--padding-3px {
    padding: 3px;
}
.g--padding-6px {
    padding: 6px;
}
.g--padding-7px {
    padding: 7px;
}
.g--padding-9px {
    padding: 9px;
}
```

# Loop @each of a map
[Up](#table-of-contents)

It is used to repeat a block of code for each element of a map.

```scss
$map:(
  "s":3px,
  "m":6px,
  "l":7px,
  "xl":9px
);
 
@each $key,$value in $map {
  .g--padding-#{$key} {
    padding: $value;
  }
}
```

It will be transformed into:
```css
.g--padding-s {
    padding: 3px;
}
.g--padding-m {
    padding: 6px;
}
.g--padding-l {
    padding: 7px;
}
.g--padding-xl {
    padding: 9px;
}
```

# Conditional @if
[Up](#table-of-contents)

It is used to apply a condition.

```scss
@mixin border($size) {
  $color:#00FF00;
     
  @if $size>=3 {
    $color:#FF0000;
  }
 
 
  border: $size*2 solid $color;
}
 
.c-caja1 {
  color: #FF0000;
  @include border(2px);
}
.c-caja2 {
  color: #FF0000;
  @include border(5px);
}
```

It will be transformed into:
```css
.c-caja1 {
  color: #FF0000;
  border: 4px solid #00FF00;
}
 
.c-caja2 {
  color: #FF0000;
  border: 10px solid #FF0000;
}
```

# Color functions
[Up](#table-of-contents)

There are some functions to work with colors.
- `lighten($color, $amount)`: Lighten a color.
- `darken($color, $amount)`: Darken a color.
- `saturate($color, $amount)`: Saturate a color.
- `desaturate($color, $amount)`: Desaturate a color.

```scss
$color-fondo: #F456E3;
$color-borde: darken($color-fondo,30%);
 
.c-caja {
    background-color: $color-fondo;
    border: 4px solid $color-borde;
}
````

It will be transformed into:
```css
.c-caja {
  background-color: #F456E3;
  border: 4px solid #a60b95;
}
```

# CSS variables
[Up](#table-of-contents)

Advantages vs SASS variables:
- They can be modified in execution time with JavaScript.
- They can exist locally inside the selectors.

Creation:
```scss
:root {
    --color-alternativo-5: #0056b8;
}
```

Use:
```scss
.c-caja {
    background-color: var(--color-alternativo-5);
}
```

It is possible to define a default value as a second parameter:
```scss
.c-button {
    background-color:var(--color-alternativo-5,#FF0000)
}
```
- In this case, if the variable `--color-alternativo-5` does not exist, the default value will be `#FF0000`.

From JavaScript, we can change them like this:
```js
let root = document.documentElement;
root.style.setProperty('--color-normal-5', "#FF0000");
```

From JavaScript, we can read them like this:
```js
let root = document.documentElement;
let colorNormal=getComputedStyle(root).getPropertyValue("--color-normal-5");
```

## Creation of a CSS variable with SASS
[Up](#table-of-contents)

```scss
$paddings:(
  "xs":"1px",
  "s":"2px",
  "m":"6px",
  "l":"12px",
  "xl":"20px"
  );
 
:root {
  @each $key,$value in $paddings {
    --padding-#{$key}:$value;
  }
}
```

It will be transformed into:
```css
:root {
  --padding-xs:1px;
  --padding-s:2px;
  --padding-m:6px;
  --padding-l:12px;
  --padding-xl:20px;
}
```

These variables will be used in components, layouts and globals:
```scss
.c-button {
    --c-button-padding-vertical:var(--padding-s,6px);
    --c-button-padding-horizontal:var(--padding-m,8px);
 
    padding-top: var(--c-button-padding-vertical);
    padding-bottom: var(--c-button-padding-vertical);
     
    padding-left: var(--c-button-padding-horizontal);
    padding-right: var(--c-button-padding-horizontal);
}
 
.g--padding-vertical-m {
  padding-top: var(--padding-m);
  padding-bottom: var(--padding-m);  
}
```