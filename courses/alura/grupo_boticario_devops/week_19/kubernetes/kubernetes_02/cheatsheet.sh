# Cria um pod do Kubernetes.
kubectl run nginx-pod --image=nginx:latest

# Lista pods.
kubectl get pods

# Lista pods em tempo real.
kubectl get pods --watch

# Lista informações de um pod.
kubectl describe pod nginx-pod

# Edita configurações do pod.
kubectl edit pos nginx-pod

# Aplica um pod de maneira declarativa.
kubectl apply -f ./primeiro-pod.yml

# Deleta um pod.
kubectl delete pod nginx-pod

# Executa um comando em um pod em execução.
kubectl exec -it portal-noticias -- bash

# Lista pods com mais informações.
kubectl get pods -o wide

# Lista serviços de pods.
kubectl get svc

# Deleta todos os pods.
kubectl delete pods --all

# No Linux, o INTERNAL-IP é utilizado para o
# mapeamento de IPs do cluster.

# Lista os ReplicaSets.
kubectl get rs

# ReplicaSets auxiliam no mantimento automático de Pods.
# Deployments englobam ReplicaSets mas permitem
# um versionamento.

# Lista as revisões de um Deployment.
kubectl rollout history deployment nginx-deployment

# Cria uma anotação para o deployment atual.
kubectl annotate deployment nginx-deployment kubernetes.io/change-cause="Definir a imagem com a versão latest"

# Volta para uma revisão do Deployment.
kubectl rollout undo deployment nginx-deployment --to-revision=2

# Executa um comando em um container
# vinculado a um volume.
kubectl exec -it pod-volume --container nginx-container -- bash