package Ip;

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */

/**
 *
 * @author Arthur
 */
public class Ip {
    public String _ip_rede_local;
    public int _porta_rede;

    public Ip() {
        _ip_rede_local = "127.0.0.1";
        _porta_rede = 5000;
    }

    public Ip(String _ip_rede_local, int _porta_rede) {
        this._ip_rede_local = _ip_rede_local;
        this._porta_rede = _porta_rede;
    }   
    
    public String getIp_rede_local() {
        return _ip_rede_local;
    }

    public int getPorta_rede() {
        return _porta_rede;
    }

    public void setIp_rede_local(String _ip_rede_local) {
        this._ip_rede_local = _ip_rede_local;
    }

    public void setPorta_rede(int _porta_rede) {
        this._porta_rede = _porta_rede;
    }                   
}
