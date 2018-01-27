var request = require('request');
var key = 'oq6daa490r0LV4JymiH_-g';
var express = require('express');
var app = express();

app.use('/static',express.static('static'));

app.listen(3000, function(){
    console.log('started');
})
app.get("/api/getHistory", function(req,response){
    console.log(req.query.ticker);
    var ticker = req.query.ticker;
    console.log(ticker);
    request('https://oec-2018.herokuapp.com/api/stock?ticker='+ticker+'&key='+key,{json:true},(err,res,body)=>{
        if(err){
            response.status(404).send();
        }
        if(typeof(body)=='undefined'){
            response.status(404).send();
        }
        response.send(body.historical_price);
    });
});

