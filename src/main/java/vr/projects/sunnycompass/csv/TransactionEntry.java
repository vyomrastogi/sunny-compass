package vr.projects.sunnycompass.csv;

public record TransactionEntry(
        String postedDate, String description, Double debit, Double credit, Double balance, String category) {

    public Double getLedgerEntryValue() {
        if (this.debit != null && debit.doubleValue() != 0) {
            return debit * -1;
        } else if (this.credit != null && credit != 0) {
            return credit;
        } else {
            return Double.valueOf(0);
        }
    }
}
