const mysql = require('mysql');

//local mysql db connectionconst 
const dbConn = mysql.createConnection({ host: 'localhost', user: 'root', password: '@Regato123@', database : 'dataBaseQA'});
dbConn.connect(function(err) {  
    if (err) throw err;
        console.log("DB conectado!");
    });

module.exports = dbConn;