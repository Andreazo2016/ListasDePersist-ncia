angular.module('myApp').factory('ContatoService',function($http,Urls){
	return {
		allContato:function(callback){
			$http.get(Urls.urlApi+'allContato')
			.then(function(sucess){
				callback(sucess.data);
			},function(erro){
				console.log("Erro at get AllContato",erro.data)
			});
		}
	};
});