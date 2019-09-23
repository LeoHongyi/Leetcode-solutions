var cheese = '奶酪';

var test = function(){
    alert(cheese);
}

alert(cheese);
alert(test);

alert(typeof test);
alert(typeof cheese);

test();

var cheese = '奶酪';
var test = function(){
    alert(cheese);
}

function test2(){
    var cheese = null;
    test();
}

test2();