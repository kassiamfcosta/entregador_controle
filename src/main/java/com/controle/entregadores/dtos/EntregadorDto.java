package com.controle.entregadores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadorDto (
		@NotBlank String cpf,
		@NotBlank String nome,
		@NotNull Float capacidadeVeiculo) {
}
