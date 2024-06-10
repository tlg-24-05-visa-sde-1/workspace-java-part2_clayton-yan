package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method - client must come here for the instance (i.e., IRSEnum.INSTANCE)
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
