import { Kafka } from 'kafkajs';

const kafka = new Kafka({
  brokers: ['localhost:9092'],
})

const topic = 'usertopic'
const consumer = kafka.consumer({ groupId: 'group-id' })

async function run() {
  await consumer.connect()
  await consumer.subscribe({ topic })

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log(`Tópico: ${topic}, Chave: ${message.key}, Mensagem: ${message.value}`)
    },
  })
}

run().catch(console.error)