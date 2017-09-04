angular.module('App',[])
.controller('HomeController',function($scope,$http){
	$scope.home = "AngularJS";
	
	$scope.items = [{name:"cat"},{name:"WC"},{name:"head"}];
	$scope.enviar = function(path,comando){
		$scope.p = path;
		$scope.c = comando;
		var data = path;
		$http.post('/'+comando+data)
		.then(function(sucess){
			$scope.msg = sucess.data;
		},function(erro){
			$scope.msg = erro.data;
		});
	}
	

});