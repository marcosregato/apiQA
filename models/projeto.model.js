const conectionDB = require('../service/dataBase')

const ProjetoDB = function(projetoDB){
    this.id   = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
}

ProjetoDB.create = function(newProjeto, result){
    conectionDB.query('insert into projeto set ? ', newProjeto, function(res, err){
        if(err){
            console.log('error', err);
            result(err, null);
            return;
        }
        console.log("criado projeto: ", { id: res.id, ...newProjeto });
        result(null, { id: res.id, ...newProjeto});
        });
};


ProjetoDB.findId = function(projetoId, result){
    conectionDB.query(`SELECT * FROM projeto WHERE id = ${projetoId}` , function(res, err){
         if(err){
            console.log('error', err);
            result(err, null);
            return;
        }
        if (res.length) {
            console.log("nao existe esse id : ", res[0]);
            result(null, res[0]);
            return;
          }
      
          // not found Customer with the id
          result({ kind: "not_found" }, null);
        });
};

ProjetoDB.getAll = result => {
    conectionDB.query("SELECT * FROM projeto", (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("projeto: ", res);
      result(null, res);
    });
  };
  
ProjetoDB.updateById = function(id, projeto, result) {
    conectionDB.query(
      "UPDATE projeto SET nome = ?, dataCriacao = ? WHERE id = ?",
      [projeto.nome, projeto.dataCriacao, id],
      (err, res) => {
        if (err) {
          console.log("error: ", err);
          result(null, err);
          return;
        }
  
        if (res.affectedRows == 0) {
          // not found Customer with the id
          result({ kind: "not_found" }, null);
          return;
        }
  
        console.log("updated projeto: ", { id: id,  });
        result(null, { id: id, ...customer });
      }
    );

};

ProjetoDB.remove = function(id, result) {
    conectionDB.query("DELETE FROM projeto WHERE id = ?", id, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the id
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("delete projeto do id: ", id);
    result(null, res);
  });
};

ProjetoDB.removeAll = result => {
    conectionDB.query("DELETE FROM projeto", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} projeto`);
    result(null, res);
  });
};

module.exports = ProjetoDB;