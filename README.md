# spring-reactive-webflux-postgres


## OpenShift

Create App Service
```
oc create 01-service.yml
```
Create Route
```
oc create 02-route.yml
```
Create ServiceAccount, Role, RoleBinding
```
oc create 03-sa-role-rb.yml
```
Create external DB Service and Endpoint
```
oc create 04-db-endpoint.yml
oc create 05-db-service.yml
```
Create ConfigMap
```
oc create 06-configmap.yml
```
Create DeploymentConfig
```
oc create 07-deploymentconfig.yml
```

## PostgreSQL setup
### Allow access from the cluster

Edit postgresql.conf
```
vim /usr/local/var/postgres/postgresql.conf
```

set listen_addresses to '*'
```
listen_addresses = '*'
```

Update pg_hba.conf to allow access from the cluster
```
vim /usr/local/var/postgres/pg_hba.conf

host    all             all             192.168.64.5/32         trust

# 192.168.64.5 is the cluster IP
```
Restart postgres
```
brew services restart postgresql
```
