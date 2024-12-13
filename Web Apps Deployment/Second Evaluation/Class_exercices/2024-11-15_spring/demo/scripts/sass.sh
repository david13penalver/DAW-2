sass ./target/classes/static/scss/main.scss ./src/main/resources/static/css/main.css
sass --no-source-map --style=compressed ./target/classes/static/scss/main.scss ./target/classes/static/css/main.css
rm -r ./target/classes/static/scss/*
