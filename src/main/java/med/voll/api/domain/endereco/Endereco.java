package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.DadosAtualizacaoMedico;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.enderecoParamentro().logradouro() != null){
            this.logradouro = dados.enderecoParamentro().logradouro();
        }
        if(dados.enderecoParamentro().bairro()!= null){
            this.bairro = dados.enderecoParamentro().bairro();
            }
        if(dados.enderecoParamentro().cep() != null)
            {
                this.cep =  dados.enderecoParamentro().cep();
            }
        if(dados.enderecoParamentro().numero()!= null){
            this.numero =  dados.enderecoParamentro().numero();
                    }
        if(dados.enderecoParamentro().complemento() != null){
            this.complemento =  dados.enderecoParamentro().complemento();

                        }
        if (dados.enderecoParamentro().cidade() != null){
            this.cidade =  dados.enderecoParamentro().cidade();
        }
        if (dados.enderecoParamentro().uf() != null){
            this.uf =  dados.enderecoParamentro().uf();
        }









    }
}
