package entities;

public class PessoaFisica extends Contribuente{
	private double gastoSaude;
	
	public PessoaFisica() {
		super();
	}
		
	public PessoaFisica(String nome, Double rendaAnual, double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double calculaImposto() {
		Double taxa = 0.0;
		if (getRendaAnual() < 20000.00) {
			taxa += (getRendaAnual() * 0.15);
		} else if (getRendaAnual() >= 20000.00 ) {
			taxa += (getRendaAnual() * 0.25);
		}
		if (gastoSaude != 0) {
			taxa = taxa - (gastoSaude * 0.50); 
		}
		return taxa;
	}

}
