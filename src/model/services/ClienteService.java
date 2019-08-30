package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class ClienteService {
	
	private ClienteDao dao = DaoFactory.criaClienteDao();
	
	public List<Cliente> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Cliente obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}

}
