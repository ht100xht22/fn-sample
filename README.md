# Function-as-a-Service Sample Project
Sample of Functions made with Spring Cloud Function


## Before you start
1. Install KinD
2. Start a KIND cluster.
```bash
kind create cluster
```
3. Install [Arkade](https://github.com/alexellis/arkade)
4. Install OpenFaas
```bash
arkade install openfaas
```
5. Enter the command and wait for everything to be running.
```bash
kubectl -n openfaas get deployments -l "release=openfaas, app=openfaas" -w
```
6. Enter the command to install `faas-cli`.
```bash
curl -SLsf https://cli.openfaas.com | sudo sh
```
7. Rollout a gateway.
```bash
kubectl rollout status -n openfaas deploy/gateway
```
8. Open up a another terminal window
9. Enter the command.
```bash
kubectl port-forward -n openfaas svc/gateway 8080:8080 &
```
10. Execute the command to generate a password for openfaas ui
```bash
PASSWORD=$(kubectl get secret -n openfaas basic-auth -o jsonpath="{.data.basic-auth-password}" | base64 --decode; echo)
echo -n $PASSWORD | faas-cli login --username admin --password-stdin
```
11. Navigate to [http://localhost:8080/ui/](http://localhost:8080/ui/)
12. Enter your credentials. You can find the password from the terminal you been working on with the command
```bash
echo $PASSWORD
```
Copy the password and enter in the webpage.
13. You are now ready to start working

## Working with OpenFaas and Spring Cloud Function
1. Download the Spring Cloud Function template for OpenFaas
```bash
faas-cli template pull https://github.com/arifjehoh/openfaas-sb-function-template
```
2. Create a function
```bash
faas-cli new <name of function> --lang=dockerfile -p=<docker-hub-username>
```
3. Start develop on the function, navigate to the src directory and find `Application.java` file and start developing.
