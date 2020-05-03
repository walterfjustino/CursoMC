package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Cliente;
import com.cursomc.dto.ClienteDTO;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.services.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
				
		public Cliente update(Cliente obj) throws ObjectNotFoundException {
			Cliente newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);	//quando o ID já existe ele só atualiza
		}
		public void delete(Integer id) throws ObjectNotFoundException {
			find(id);
			try {
				repo.deleteById(id);
				
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
		}

		public List<Cliente> findAll() {
			return repo.findAll();
		}
		
		public Page<Cliente> findPage(Integer Page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(Page, linesPerPage, Direction.valueOf(direction),orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Cliente fromDTO(ClienteDTO objDto) {
			return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
		
		private void updateData(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}
}
