const express = require('express');
const app = express();
const morgan = require('morgan');
const bodyParser = require('body-parser');
const cors = require('cors');
const routes = require('./routes/routes')


app.use(morgan('dev'));
app.use(bodyParser.urlencoded({extended: false}));
app.use(express.json()); 


/*
app.use(function(req, res, next){
    res.header("Access-Control-Allow-Origin", "http://localhost:8080");
    res.header("Access-Control-Allow-Methods", 'GET,PUT,POST,DELETE');
    app.use(cors());
    next();
})
*/


app.use(routes)


app.listen(8081, function(){
   console.log("DEU CETO")
})



