const ProjetoModel = require("../models/projeto.model.js");

exports.create = (req, res) => {
    // Validate request
  if (!req.body) {
      res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a Customer
  const projeto = new Projeto({
    id: req.body.id,
    nnome: req.body.nome,
    dataCriacao: req.body.dataCriacao
  });
  ProjetoModel.create(projeto, function(err, data) {
    if (err)
        res.status(500).send({
            message:
            err.message || "Some error occurred while creating the Customer."
      });
    else res.send(data);
  });

};

exports.findAll = (req, res) => {
    ProjetoModel.getAll(function(err, data)  {
        if (err)
          res.status(500).send({
            message:
              err.message || "Some error occurred while retrieving customers."
          });
        else res.send(data);
      });

};

exports.findOne = function(req, res) {
    ProjetoModel.findById(req.params.projetoId, function(err, data) {
        if (err) {
          if (err.kind === "not_found") {
            res.status(404).send({
              message: `Not found Customer with id ${req.params.customerId}.`
            });
          } else {
            res.status(500).send({
              message: "Error retrieving Customer with id " + req.params.customerId
            });
          }
        } else res.send(data);
      });
 
};

exports.update = function(req, res) {
    // Validate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  ProjetoModel.updateById(
    req.params.projetoId,
    new Projeto(req.body),
    (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Customer with id ${req.params.projetoId}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating Customer with id " + req.params.projetoId
          });
        }
      } else res.send(data);
    }
  );
 
};

exports.delete = (req, res) => {
    ProjetoModel.remove(req.params.customerId, (err, data) => {
        if (err) {
          if (err.kind === "not_found") {
            res.status(404).send({
              message: `Not found projeto with id ${req.params.projetoId}.`
            });
          } else {
            res.status(500).send({
              message: "Could not delete Customer with id " + req.params.projetoId
            });
          }
        } else res.send({ message: 'Projeto was deleted successfully!' });
      });
 
};

exports.deleteAll = (req, res) => {
    ProjetoModel.removeAll((err, data) => {
        if (err)
          res.status(500).send({
            message:
              err.message || "Some error occurred while removing all customers."
          });
        else res.send({ message: 'All Customers were deleted successfully!' });
      });
 
};
