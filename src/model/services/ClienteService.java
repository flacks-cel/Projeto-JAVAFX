package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Cliente;

public class ClienteService {
	
	public List<Cliente> findAll(){
		List<Cliente> list = new ArrayList<Cliente>();
		list.add(new Cliente(1, "Padaria do Mané", "Pão quentinho"));
		list.add(new Cliente(2,"Posto Ipiranga", "Milhas de vantagem"));
		list.add(new Cliente(3, "Gol linhas aereas", "Voe Gol"));
		list.add(new Cliente(4, "Volkswagen", "Novo Polo"));
		list.add(new Cliente(5, "Nubank", "Faça seu cartão"));
		return list;
	}

}
