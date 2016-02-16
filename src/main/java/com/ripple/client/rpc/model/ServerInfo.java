package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * A POJO for the server_info response from rippled
 * 
 * @author Cristian Sandu
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerInfo {
	/*
	 * Full info is: 
	 * {info={build_version=0.28.1+DEBUG,
	 * complete_ledgers=3-3880, hostid=hi25546, io_latency_ms=1,
	 * last_close={converge_time_s=2.001, proposers=0},
	 * load={job_types=[{in_progress=1, job_type=clientCommand}], threads=6},
	 * load_factor=1, peers=0,
	 * pubkey_node=n9M1zj1EG9zG2wnpd5y59E1yxiKw5M61BSSj7dPRUzsCvmeDHgK7,
	 * pubkey_validator=n9MACqEkbXvUwZ1EZ4pdSyE75VtZpnJweHeEPaixJLEjehxy4PgX,
	 * server_state=proposing, validated_ledger={age=22, base_fee_xrp=0,
	 * hash=E7DDBAA3CC620166283A51CFCF1449DB63CEE9FF5B3D115AFB3A6FA288FB30F6,
	 * reserve_base_xrp=0, reserve_inc_xrp=0, seq=3880}, validation_quorum=1},
	 * status=success}
	 */
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class LocalNodeInfo {
		@JsonProperty("build_version")
		public String buildVersion;

		@JsonProperty("complete_ledgers")
		public String completeLedgers;
		
		@JsonProperty("pubkey_node")
		public String nodePubKey;
		
		@JsonProperty("pubkey_validator")
		public String validatorPubKey;
		
		// TODO: make this an enum
		@JsonProperty("server_state")
		public String serverState;
		
		@JsonProperty("validation_quorum")
		public Integer quorum;
	}
	
	public LocalNodeInfo info;
}
