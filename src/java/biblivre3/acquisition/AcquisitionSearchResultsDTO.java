/**
 *  Este arquivo é parte do Biblivre3.
 *  
 *  Biblivre3 é um software livre; você pode redistribuí-lo e/ou 
 *  modificá-lo dentro dos termos da Licença Pública Geral GNU como 
 *  publicada pela Fundação do Software Livre (FSF); na versão 3 da 
 *  Licença, ou (caso queira) qualquer versão posterior.
 *  
 *  Este programa é distribuído na esperança de que possa ser  útil, 
 *  mas SEM NENHUMA GARANTIA; nem mesmo a garantia implícita de
 *  MERCANTIBILIDADE OU ADEQUAÇÃO PARA UM FIM PARTICULAR. Veja a
 *  Licença Pública Geral GNU para maiores detalhes.
 *  
 *  Você deve ter recebido uma cópia da Licença Pública Geral GNU junto
 *  com este programa, Se não, veja em <http://www.gnu.org/licenses/>.
 * 
 *  @author Alberto Wagner <alberto@biblivre.org.br>
 *  @author Danniel Willian <danniel@biblivre.org.br>
 * 
 */

package biblivre3.acquisition;

import java.util.ArrayList;
import java.util.Properties;
import mercury.DTO;
import org.json.JSONException;
import org.json.JSONObject;

public class AcquisitionSearchResultsDTO extends DTO {
    public ArrayList<DTO> al;
    public int totalPages;
    public int totalRecords;
    public int currentPage;
    public int recordsPerPage;

    @Override
    public JSONObject toJSONObject(Properties properties) {
        JSONObject json = new JSONObject();
        try {
            json.put("totalPages", this.totalPages);
            json.put("totalRecords", this.totalRecords);
            json.put("currentPage", this.currentPage);
            json.put("recordsPerPage", this.recordsPerPage);
            
            for (DTO rr : this.al) {
                json.append("results", rr.toJSONObject(null));
            }
        } catch (JSONException e) {
        }
        
        return json;        
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
