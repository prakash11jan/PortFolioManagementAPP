# PortFolioManagementAPP
Tips:
1.Assumed that user base is already there in place
2. the below functionality to get the Asset details of the particular user and display
3. used angular databinding to refresh the asset details every 10 minutes
4.to update price api also in the same service (PortFolioManagementApp), if it needs to be separate service then we can move it to separate service with multi nodes.
5. Load balancing and scalability is leveraged with spring cloud Eureka and Zuul proxy.



DataModel:
 
CREATE TABLE User (
  id number( 20 ) NOT NULL PRIMARY KEY,
  first_name    VARCHAR(45) NOT NULL,
  last_name    VARCHAR(45) NOT NULL,
  email    VARCHAR(45) NOT NULL,
  
);

CREATE TABLE AssetDetails (
  id numeric(20) NOT NULL PRIMARY KEY,
  asset_id  numeric(20) NOT NULL PRIMARY KEY,
  user number( 20 ) NOT NULL,
  asset_count numer(20),
  total_price Number(10,2) NOT NULL,
  type  VARCHAR  NOT NULL,
  FOREIGN KEY (user) REFERENCES User(id)
  FOREIGN KEY (asset_id) REFERENCES Asset(id)
);

CREATE TABLE Asset(
  
  id  numeric(20) NOT NULL PRIMARY KEY IDENTITY,
  user number( 20 ) NOT NULL,
  asset_name    VARCHAR(45) NOT NULL,
  price Number(10,2) NOT NULL,
  type  VARCHAR  NOT NULL,
  
);



Services:

Get all Aseets of a user:
GET: http://localhost:8091/portfolio/assets/{userId}

Get a Asset deatil:
GET: http://localhost:8091/portfolio/assetDetail/{id}

Update Price:
POST: http://localhost:8091/portfolio/asset/{id}

request Body:
{
 "id" : 1234,
 "name" : "infosys",
 "price" : 1000,
 "type" : "NON_CASH"

}


Open Source:
1.	spring-cloud-starter-netflix-eureka-server – for sacalability and load balancing
2.	spring-boot-starter-data-jpa – sql/oracleDB management
3.	angular10 – for refreshing the page every 10 minutes
