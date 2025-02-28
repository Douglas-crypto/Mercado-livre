package classes;

import org.mindrot.jbcrypt.BCrypt;

public class GerenciaSenha {
    private static final int SALT_ROUNDS = 12;

    // Metodo utilizado para criptografar a senha usando a lib BCrypt
    public String criptografarSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt(SALT_ROUNDS));
    }

    // Compara a senha digitada com o hash armazenado. Dentro do proprio metodo, por segurança
    public boolean verificarSenha(String senhaPura, String senhaCriptografada) {
        try {
            return BCrypt.checkpw(senhaPura, senhaCriptografada);
        } catch (Exception e) {
            return false;
        }
    }
}
