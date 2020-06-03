package br.com.confeccao.enums;

public enum TipoDespesa {
	
	MATERIAL(1),
	MÂO_DE_OBRA(2),
	OUTROS(3);
	
	private int code;
	
	private TipoDespesa(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoDespesa valueOf(int code) {
		for(TipoDespesa value : TipoDespesa.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de tipo de despesa inválido");
	}
}
