angular.module('myApp').controller('ContatoController',function($scope,$http,ContatoService){
	$scope.listaContato = [];
	
	ContatoService.allContato(function(data){
		console.log(data);
		$scope.listaContato = data;
	});
	
});