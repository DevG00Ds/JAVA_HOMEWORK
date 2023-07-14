public class Notebook {
    int id;
    String company;
    String model;
    String color;

    int RamSize;
    int Ramfreq;

    String CPUcompany;
    String CPUmodel;
    int CPUcore;
    double Memoryfreq;

    int HDDsize;

    String DisplayType;
    double DisplaySize;

    public Notebook(int id,
                    String company,
                    String model,
                    String color,
                    int RamSize,
                    int Ramfreq,
                    String CPUcompany,
                    String CPUmodel,
                    int CPUcore,
                    double Memoryfreq,
                    int HDDsize,
                    String DisplayType,
                    double DisplaySize) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.color = color;

        this.RamSize = RamSize;
        this.Ramfreq = Ramfreq;

        this.CPUcompany = CPUcompany;
        this.CPUmodel = CPUmodel;
        this.CPUcore = CPUcore;
        this.Memoryfreq = Memoryfreq;

        this.HDDsize = HDDsize;

        this.DisplayType = DisplayType;
        this.DisplaySize = DisplaySize;
    }

    @Override
    public String toString() {
        return String.format("id: %s\n%s %s %s\nRAM: %s Gb\nHDD: %s\nCPU: %s %s\ncores: %s\nfr: %s GHz",
                             id, company, model, color,
                             RamSize, HDDsize,
                             CPUcompany, CPUmodel,
                             CPUcore,
                             Memoryfreq);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook other = (Notebook)obj;
        return this.company.equals(other.company) &&
               this.model.equals(other.model) &&
               this.RamSize == other.RamSize &&
               this.CPUcompany.equals(other.CPUcompany) &&
               this.CPUmodel.equals(other.CPUmodel) &&
               this.CPUcore == other.CPUcore &&
               this.Memoryfreq == other.Memoryfreq &&
               this.DisplaySize == other.DisplaySize;
    }
}