package json.pojo;

import java.math.BigDecimal;

/**
 * Created by yangheng on 2017/6/9.
 */
public class FinanceProfit {
    private BigDecimal receivedProfit=BigDecimal.ZERO;
    private BigDecimal vipBalance=BigDecimal.ZERO;
    private int profitAccountVersion;

    public BigDecimal getReceivedProfit() {
        return receivedProfit;
    }

    public void setReceivedProfit(BigDecimal receivedProfit) {
        this.receivedProfit = receivedProfit;
    }

    public BigDecimal getVipBalance() {
        return vipBalance;
    }

    public void setVipBalance(BigDecimal vipBalance) {
        this.vipBalance = vipBalance;
    }

    public int getProfitAccountVersion() {
        return profitAccountVersion;
    }

    public void setProfitAccountVersion(int profitAccountVersion) {
        this.profitAccountVersion = profitAccountVersion;
    }
}
