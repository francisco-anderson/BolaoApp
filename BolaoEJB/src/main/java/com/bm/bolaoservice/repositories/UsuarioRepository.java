package com.bm.bolaoservice.repositories;

import java.util.List;

import com.bm.bolaoservice.entity.Usuario;

public interface UsuarioRepository extends AbstractRepository<Usuario, Long> {

	
	public List<Usuario> consultarUsuarioPorEmail(String email);
	public boolean realizarLogin(String email, String senha);
	
}
