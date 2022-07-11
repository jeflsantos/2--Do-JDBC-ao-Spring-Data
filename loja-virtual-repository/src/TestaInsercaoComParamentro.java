import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParamentro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricacao) VALUES (?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("SmartTv", "45 polegadas", stm);
		adicionarVariavel("Radio", "Radio de Bateria", stm);

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " +id);
			
		}
	}

}
