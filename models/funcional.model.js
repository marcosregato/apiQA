const conectionDB = require('../service/dataBase')

const FuncionalDB = function(funcionalDB){
    this.id   = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
}

FuncionalDB.create = function(newProjeto, result){
    conectionDB.query('insert into projeto set ? ', newProjeto, function(res, err){
        if(err){
            console.log('error', err);
            result(err, null);
            return;
        }
        console.log("criado funcional: ", { id: res.id, ...newProjeto });
        result(null, { id: res.id, ...newProjeto});
        });
};


FuncionalDB.findId = function(projetoId, result){
    conectionDB.query('SELECT * FROM funcional WHERE id = ${projetoId}' , function(res, err){
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

FuncionalDB.getAll = result => {
    conectionDB.query("SELECT * FROM funcional", (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("projeto: ", res);
      result(null, res);
    });
  };
  
FuncionalDB.updateById = function(id, projeto, result) {
    conectionDB.query(
      "UPDATE funcional SET nome = ?, dataCriacao = ? WHERE id = ?",
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
  
        console.log("updated funcional: ", { id: id, ...customer });
        result(null, { id: id, ...customer });
      }
    );

};

FuncionalDB.remove = function(id, result) {
    conectionDB.query("DELETE FROM funcional WHERE id = ?", id, (err, res) => {
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

    console.log("delete funcional do id: ", id);
    result(null, res);
  });
};

FuncionalDB.removeAll = result => {
    conectionDB.query("DELETE FROM funcional", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} funcional`);
    result(null, res);
  });
};

module.exports = FuncionalDB;