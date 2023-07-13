package Homework_6;

public class notebook {
    int id ;
    String company;
    String model;
    String color;

    double DisplaySize;
    String DisplayType;

    int RamSize;
    int Ramfreq;

    String CPUcompany;
    String CPUmodel;
    int CPUcore;
    double Memoryfreq;

    int HDDsize;

    public notebook(
        int id,
        String company, 
        String model, 
        String color, 
        double DisplaySize, 
        String DisplayType,
        int RamSize, 
        int Ramfreq,
        String CPUcompany, 
        String CPUmodel, 
        int CPUcore, 
        double Memoryfreq, 
        int HDDsize) {
            this.id = id;
            this.company = company;
            this.model = model;
            this.color = color;
            this.DisplaySize = DisplaySize;
            this.DisplayType = DisplayType;
            this.RamSize = RamSize;
            this.Ramfreq = Ramfreq;
            this.CPUcompany = CPUcompany;
            this.CPUmodel = CPUmodel;
            this.CPUcore = CPUcore;
            this.Memoryfreq = Memoryfreq;
            this.HDDsize = HDDsize;
    }
    
    
    @Override
    public String toString() {
        return String.format("id: %s\n%s %s %s\nRAM: %s Gb\nHDD: %s\nCPU: %s %s\ncores: %s\nfr: %s GHz",
                            id,company,model,color,DisplaySize,DisplayType,
                            RamSize,Ramfreq,CPUcompany,CPUmodel,CPUcore,Memoryfreq,
                            HDDsize);
    }

    @Override
    public boolean equals(Object object) {
        if( object == this) {
            return true;
        }
        if ( !(object instanceof notebook)){
            return false;
        }

        notebook other = (notebook)object;
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
