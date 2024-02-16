package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.LockMode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.jetbrains.annotations.Blocking;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "modificationserver", schema = "dbo", catalog = "storage")
@NamedQuery(name="ModificationServerEntity.findAll", query="SELECT modif FROM model.ModificationServerEntity modif")
public class ModificationServerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;


    @Basic
    @Column(name = "versionserver", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS" )
    private Date versionserver;
    @Basic
    @Column(name = "type_query", nullable = false, length = 100)
    private String typeQuery;
    @Basic
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic
    @Column(name = "versionserverversion", nullable = true, precision = 0)
    private Long versionserverversion;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVersionserver() {
        return versionserver;
    }

    public void setVersionserver(Date versionserver) {
        this.versionserver = versionserver;
    }

    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVersionserverversion() {
        return versionserverversion;
    }

    public void setVersionserverversion(Long versionserverversion) {
        this.versionserverversion = versionserverversion;
    }


}
