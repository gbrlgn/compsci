package aluno;

public class CifradorSenhaMD5 implements CifradorSenha {
    @Override
    String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash MD5");
        }
    }

    @Override
    boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }
}