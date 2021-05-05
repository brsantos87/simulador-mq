package br.org.caixa.jms.config;
public class PropriedadesMQ {
	
	private Integer timeout;
	
	private String connectionFactory;
	
	private String filaRequisicao;
	
	
	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public String getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(String connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public String getFilaRequisicao() {
		return filaRequisicao;
	}

	public void setFilaRequisicao(String filaRequisicao) {
		this.filaRequisicao = filaRequisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionFactory == null) ? 0 : connectionFactory.hashCode());
		result = prime * result + ((filaRequisicao == null) ? 0 : filaRequisicao.hashCode());
		result = prime * result + ((timeout == null) ? 0 : timeout.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropriedadesMQ other = (PropriedadesMQ) obj;
		if (connectionFactory == null) {
			if (other.connectionFactory != null)
				return false;
		} else if (!connectionFactory.equals(other.connectionFactory))
			return false;
		if (filaRequisicao == null) {
			if (other.filaRequisicao != null)
				return false;
		} else if (!filaRequisicao.equals(other.filaRequisicao))
			return false;
		if (timeout == null) {
			if (other.timeout != null)
				return false;
		} else if (!timeout.equals(other.timeout))
			return false;
		return true;
	}
	
	

}