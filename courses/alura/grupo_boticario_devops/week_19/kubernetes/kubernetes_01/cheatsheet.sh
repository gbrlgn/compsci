# Cria um pod do Kubernetes.
kubectl run nginx-pod --image=nginx:latest

# Listar pods.
kubectl get pods

# Listar pods em tempo real.
kubectl get pods --watch

# Listar informações de um pod.
kubectl describe pod nginx-pod

# Editar configurações do pod.
kubectl edit pos nginx-pod

# Aplicar um pod de maneira declarativa.
kubectl apply -f ./primeiro-pod.yml

# Deletar um pod.
kubectl delete pod nginx-pod

# Executar um comando em um pod em execução.
kubectl exec -it portal-noticias -- bash

# Listar pods com mais informações.
kubectl get pods -o wide

# Listar serviços de pods.
kubectl get svc

# Deletar todos os pods.
kubectl delete pods --all