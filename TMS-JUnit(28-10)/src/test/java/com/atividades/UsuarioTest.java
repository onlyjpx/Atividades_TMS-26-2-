package com.atividades;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void nomeNaoPodeSerNuloOuVazio(String nome) {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(nome, "joao@gmail.com"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void emailNaoPodeSerNuloOuVazio(String email) {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("João Silva", email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Joao", "João Silva", "Maria das Dores"})
    void nomeValidoDeveSerAceito(String nome) {
        Usuario u = new Usuario(nome, "joao@gmail.com");
        assertEquals(nome, u.getNome());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Joao123", "João@Silva", "Maria_Silva", "Ana-Paula", "João  Silva", " João"})
    void nomeComNumeroOuCaractereEspecialDeveLancarExcecao(String nome) {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(nome, "joao@gmail.com"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"joao@gmail.com", "joao.silva@ufu.br", "joao_silva@dominio", "joao123@site2"})
    void emailValidoDeveSerAceito(String email) {
        Usuario u = new Usuario("João Silva", email);
        assertEquals(email, u.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "joaogmail.com",
            "@gmail.com",
            "joao@",
            "joão@gmail.com",
            "joao-silva@gmail.com",
            "joao@gmail_com",
            "joao@@gmail.com",
            "joao silva@gmail.com"
    })
    void emailInvalidoDeveLancarExcecao(String email) {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("João Silva", email));
    }
}