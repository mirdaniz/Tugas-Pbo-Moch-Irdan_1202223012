package repository;

import model.Prodi;

public class ProdiTbl {
     private Database db;

        public ProdiTbl(Database db) {
            this.db = db;
        }

        public void create(Prodi prodi) {
            db.tables.dataProdi.add(prodi);
            db.commit();
        }
        
        public Prodi getProdiById(String id) {
            for (Prodi prodi : db.tables.dataProdi) {
                if (prodi.getId().equals(id)) {
                    return prodi;
                }
            }
            return null;
        }
        public void delete(String id){
            for(int i = 0; i < db.tables.dataProdi.size(); i++) {
                if(db.tables.dataProdi.get(i).getId().equals(id)) {
                    db.tables.dataProdi.remove(i);
                    break;
                }
            }
            db.commit();
    }
}
